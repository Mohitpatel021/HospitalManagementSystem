package com.HMSApp.Hospital.Management.System.ServiceImpl;

import com.HMSApp.Hospital.Management.System.DTO.JwtResponse;
import com.HMSApp.Hospital.Management.System.DTO.LoginRequest;
import com.HMSApp.Hospital.Management.System.DTO.UserDTO;
import com.HMSApp.Hospital.Management.System.Entity.CommonRequest;
import com.HMSApp.Hospital.Management.System.Entity.DoctorEntity;
import com.HMSApp.Hospital.Management.System.Entity.Role;
import com.HMSApp.Hospital.Management.System.Entity.UserRegisterEntity;
import com.HMSApp.Hospital.Management.System.Exception.AuthenticationFailedException;
import com.HMSApp.Hospital.Management.System.Exception.InternalServerException;
import com.HMSApp.Hospital.Management.System.Repository.DoctorRepository;
import com.HMSApp.Hospital.Management.System.Repository.UserRepository;
import com.HMSApp.Hospital.Management.System.Service.JwtService;
import com.HMSApp.Hospital.Management.System.Service.RegisterAndLoginService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterAndLoginServiceImpl implements RegisterAndLoginService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public ResponseEntity<Map<String, String>> registerUser(
    CommonRequest commonRequest
  ) {
    if (
      commonRequest.getRole() == Role.USER &&
      userRepository.existsByUsername(commonRequest.getUsername())
    ) {
      throw new InternalServerException(
        "Username is already exist !! Please User another one"
      );
    }
    if (
      commonRequest.getRole() == Role.DOCTOR &&
      doctorRepository.existsByUsername(commonRequest.getUsername())
    ) {
      throw new InternalServerException(
        "Email is already exist !! Please User another one"
      );
    } else if (commonRequest.getRole() == Role.USER) {
      UserRegisterEntity userRegisterEntity = new UserRegisterEntity();
      userRegisterEntity.setUserName(commonRequest.getUsername());
      userRegisterEntity.setPassword(
        passwordEncoder.encode(commonRequest.getPassword())
      );
      userRegisterEntity.setPhoneNumber(commonRequest.getPhoneNumber());
      userRegisterEntity.setUser_Age(commonRequest.getAge());
      userRegisterEntity.setUser_Address(commonRequest.getAddress());
      userRegisterEntity.setRole(commonRequest.getRole());
      userRegisterEntity.setUser_Gender(commonRequest.getGender());
      userRegisterEntity.setEmail(commonRequest.getEmail());
      userRepository.save(userRegisterEntity);
      UserDTO userDTO = UserDTO.entityToDTO_Mapper(userRegisterEntity);
      Map<String, String> response = new HashMap<String, String>();
      response.put("Message", "User Register Successfully");
      return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
      DoctorEntity doctorEntity = new DoctorEntity();
      doctorEntity.setUsername(commonRequest.getUsername());
      doctorEntity.setPassword(
        passwordEncoder.encode(commonRequest.getPassword())
      );
      doctorEntity.setDoc_phoneNumber(commonRequest.getPhoneNumber());
      doctorEntity.setAge(commonRequest.getAge());
      doctorEntity.setDoc_Address(commonRequest.getAddress());
      doctorEntity.setRole(commonRequest.getRole());
      doctorEntity.setGender(commonRequest.getGender());
      doctorEntity.setEmail(commonRequest.getEmail());
      doctorRepository.save(doctorEntity);
      //			DoctorDTO doctorDTO = DoctorDTO.entityToDTO(doctorEntity);
      Map<String, String> response = new HashMap<String, String>();
      response.put("Message", "Doctor Register Successfully");
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
  }

  //	public ResponseEntity<?> registerDoctor(DoctorDTO doctorDTO) {
  //		try {
  //			if (doctorRepository.existsByUsername(doctorDTO.getUsername())) {
  //				return ResponseEntity.badRequest()
  //						.body("Doctor Username is already exist !! Please Use other username");
  //			}
  //			DoctorEntity doctorEntity = new DoctorEntity();
  //			doctorEntity = DoctorDTO.dtoToEntity(doctorDTO);
  //			doctorRepository.save(doctorEntity);
  //			DoctorDTO doctorDTO1 = DoctorDTO.entityToDTO(doctorEntity);
  //			return new ResponseEntity<>(doctorDTO1, HttpStatus.OK);
  //		} catch (Exception e) {
  //			throw new InternalServerException("Failed to register a Doctor !!");
  //		}
  //	}

  public JwtResponse login(LoginRequest loginRequest) {
    if (
      !userRepository.existsByUsername(loginRequest.getUsername()) &&
      !doctorRepository.existsByUsername(loginRequest.getUsername())
    ) {
      throw new AuthenticationFailedException(
        "Authentication Failed !!User Not Found"
      );
    }
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        loginRequest.getUsername(),
        loginRequest.getPassword()
      )
    );

    String jwtToken = null;
    JwtResponse jwtResponse = new JwtResponse();
    if (userRepository.existsByUsername(loginRequest.getUsername())) {
      UserRegisterEntity userEntity = userRepository.findByUsername(
        loginRequest.getUsername()
      );
      jwtToken = jwtService.generateToken(userEntity);
      jwtResponse.setRole(userEntity.getRole());
    } else {
      DoctorEntity doctorEntity = doctorRepository.findByUsername(
        loginRequest.getUsername()
      );
      jwtToken = jwtService.generateToken(doctorEntity);
      jwtResponse.setRole(doctorEntity.getRole());
    }
    jwtResponse.setToken(jwtToken);
    jwtResponse.setTokenType("Bearer");
    jwtResponse.setUsername(loginRequest.getUsername());
    return jwtResponse;
  }
}
