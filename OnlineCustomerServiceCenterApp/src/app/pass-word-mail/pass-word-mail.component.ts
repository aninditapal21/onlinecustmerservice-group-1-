import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmailDetails } from '../model/email-details';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-pass-word-mail',
  templateUrl: './pass-word-mail.component.html',
  styleUrls: ['./pass-word-mail.component.css']
})
export class PassWordMailComponent implements OnInit {
  msg: string;
  customerId: number;
  details: EmailDetails = new EmailDetails();
  constructor(private r: ActivatedRoute, private cs:CustomerserviceService) { }

  ngOnInit() {
  }
  public sendPassword() {
    this.details.subject = "Hello Your Password Is..";
    this.cs.sendpassword(this.details, this.customerId).subscribe(response => {
      this.msg = response;
      console.log(response);
      if (this.msg == "mail send successfully...")
        alert("mail sent");
      window.location.reload();
    });

  }
}
