export class CommonRegisterRequest {
  username: string;
  password: string;
  phoneNumber: string;
  email: string;
  age: string;
  gender: string;
  address: string;
  role: Role;
}

export enum Role {
  USER,
  DOCTOR,
}
