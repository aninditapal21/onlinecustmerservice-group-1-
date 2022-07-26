import { Component, OnInit } from '@angular/core';
import { Issue } from '../model/issue';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-customerviewissue',
  templateUrl: './customerviewissue.component.html',
  styleUrls: ['./customerviewissue.component.css']
})
export class CustomerviewissueComponent implements OnInit {
  issue: Issue[] = [];
  constructor(private cs:CustomerserviceService) { }

  ngOnInit() {
    this.cs.extractIssue().subscribe(
      response => {
        this.issue = response;
      }
    );
  }
  public reopenissue(customerId: number) {
    this.cs.reopenIssueById(customerId).subscribe(response => {
      console.log(response);
      alert("Issue reopening");
      window.location.reload();
    });
  }

}
