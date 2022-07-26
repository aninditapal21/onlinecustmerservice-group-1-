import { Call } from "./call";
import { Solution } from "./solution";

export class Issue {
    public issueId:string;
    public issueType:string;
    public description:string;
    public issueStatus:string;
    public call:Call=new Call();
    public solution:Solution=new Solution();
}
