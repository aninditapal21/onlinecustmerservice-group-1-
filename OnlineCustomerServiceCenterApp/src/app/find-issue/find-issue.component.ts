import { Component, OnInit } from '@angular/core';
import { Issue } from '../model/issue';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-find-issue',
  templateUrl: './find-issue.component.html',
  styleUrls: ['./find-issue.component.css']
})
export class FindIssueComponent implements OnInit {
  customerId: number;
  issue: Issue;
  constructor(private cs:CustomerserviceService) { }

  ngOnInit() {
    
  }
  public findissuebyid() {
    this.cs.extractIssueById(this.customerId).subscribe(response => {
      this.issue = response;
      console.log(response);
    })
  }

}
