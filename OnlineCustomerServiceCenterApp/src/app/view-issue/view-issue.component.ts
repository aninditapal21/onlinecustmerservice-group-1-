import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Issue } from '../model/issue';
import { IssueServiceService } from '../service/issue-service.service';

@Component({
  selector: 'app-view-issue',
  templateUrl: './view-issue.component.html',
  styleUrls: ['./view-issue.component.css']
})
export class ViewIssueComponent implements OnInit {
  msg:string;
  issue:Issue;
  issueId:string;
  issueStatus:string;
  operatorId:number;
  issuearray:Issue[]=[];
  constructor(private is:IssueServiceService,private router:Router,private r:ActivatedRoute) { }

  ngOnInit() {
    this.operatorId=this.r.snapshot.params['optId'];
    console.log(this.operatorId);
    this.is.extractIssue().subscribe(response=>{
      this.issuearray=response;
      console.log(response);
    });
  }
  public editIssue(operatorId:number){
    //this.router.navigate(["updatedIssueForm",operatorId]);
    this.router.navigate(['updatedIssueForm',operatorId])
  }
  public closeIssue(operatorId:number){
    //this.issue.issueId=this.issueId;
    //this.issue.issueStatus=this.issueStatus;
    this.is.closeCustomerIssue(operatorId).subscribe(response=>{
      console.log(response);
      //this.msg=`${this.issueId}`+" Close";
      //alert(this.msg);
      alert("Issue is close");
      window.location.reload();
    });
  }
  /*public deleteDept(departmentId:number){
    this.ds.deletedept(departmentId).subscribe(response=>{
      console.log(response);
      this.msg=`${departmentId}`+" deleted";
      alert(this.msg);
      window.location.reload();
    });  
    public updateIssue(){
    this.issue.issueId=this.issueId;
    this.issue.issueStatus=this.issueStatus;
    this.is.updateIssue(this.issue,this.operatorId).subscribe(response=>{
      console.log(response);
      alert("Issue is Updated");
      this.router.navigate(['viewCustomerIssue']);
    })
  }*/

}
