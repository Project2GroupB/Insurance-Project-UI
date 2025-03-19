import { Policy } from "./policy";

export class User {
    userId!: number;
    firstName!: string;
    lastName!: string;
    email!: string;
    mobileNo!: string;
    policy!: Policy[]; // Change to an array
}

