import { Customer } from "./customer";
import { Issue } from "./issue";
import { Operator } from "./operator";

export class Call {
    public callId:number;
    public callDate:Date;
    public callDuration:number;
    public phoneNumber:string;
    public customer:Customer=new Customer();
    public operator:Operator=new Operator();
}
