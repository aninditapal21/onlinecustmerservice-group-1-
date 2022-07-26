import { Component, OnInit } from '@angular/core';
import { EmailDetails } from '../model/email-details';
import { MailServiceService } from '../service/mail-service.service';

@Component({
  selector: 'app-intimation-mail',
  templateUrl: './intimation-mail.component.html',
  styleUrls: ['./intimation-mail.component.css']
})
export class IntimationMailComponent implements OnInit {
  customerId:number;
  details:EmailDetails=new EmailDetails();
  msg:string;
  constructor(private ms:MailServiceService) { }

  ngOnInit() {
  }
  public sendingIntimationMail(){
    this.details.subject="Intimation Mail";
    this.ms.sendIntimationMail(this.details,this.customerId).subscribe(response=>{
      this.msg=response;
      if(this.msg=="mail send successfully...")
        alert("Mail send successfully..");
      window.location.reload();
    });
  }

}
