import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Call } from '../model/call';
import { Issue } from '../model/issue';
import { IssueServiceService } from '../service/issue-service.service';

@Component({
  selector: 'app-update-issue-form',
  templateUrl: './update-issue-form.component.html',
  styleUrls: ['./update-issue-form.component.css']
})
export class UpdateIssueFormComponent implements OnInit {
//operatorId:number;
issue:Issue;
operatorId:number;
//call:Call;
issueId:string;
issueStatus:string;

  constructor(private r:ActivatedRoute,private is:IssueServiceService,private router:Router) { }

  ngOnInit() {
    this.operatorId=this.r.snapshot.params['optId'];
    console.log(this.operatorId);
    this.is.extractIssueById(this.operatorId).subscribe(response=>{
      this.issue=response;
      this.issueId=this.issue.issueId;
      this.issueStatus=this.issue.issueStatus;
    });
  }
  public updateIssue(){
    this.issue.issueId=this.issueId;
    this.issue.issueStatus=this.issueStatus;
    this.is.updateIssue(this.issue,this.operatorId).subscribe(response=>{
      console.log(response);
      alert("Issue is Updated");
      this.router.navigate(['viewCustomerIssue']);
    });
  }
  
}
