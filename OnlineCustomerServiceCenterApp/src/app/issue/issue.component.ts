import { Component, OnInit } from '@angular/core';
import { Issue } from '../model/issue';
import { IssueServiceService } from '../service/issue-service.service';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {
  issue:Issue=new Issue();
  constructor(private is:IssueServiceService) { }

  ngOnInit() {
  }
  public addCustomerIssue(){
    console.log(this.issue);
    this.is.addCustomerIssue(this.issue).subscribe(response=>{
      alert("Issue added");
      window.location.reload();
    })
  }

}
