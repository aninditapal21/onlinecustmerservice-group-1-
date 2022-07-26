import { Login } from "./login";

export class Customer {
    public customerId: number;
    public firstName: string;
    public lastName: string;
    public email: string;
    public mobile: string;
    public city: string;
    public login:Login=new Login();
}
