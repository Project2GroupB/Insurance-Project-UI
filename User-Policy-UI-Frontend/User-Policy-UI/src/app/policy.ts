import { User } from "./user";

export class Policy {
    policyId!: number;
    policySerialNo!: number;
    policyName!: string;
    policyStatus!: string;
    policyTerm!: string;
    policyCoverage!: string;

    // Reference to the User instance (optional, depending on use case)
    user!: User;
}
