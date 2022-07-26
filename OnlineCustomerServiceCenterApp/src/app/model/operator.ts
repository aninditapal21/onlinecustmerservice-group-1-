import { Department } from "./department";

export class Operator {
    public operatorId:number;
    public firstName:string;
    public lastName:string;
    public email:string;
    public mobile:string;
    public city:string;
    public department:Department=new Department();
}
