import { Component, OnInit } from '@angular/core';
import { EmailDetails } from '../model/email-details';
import { IssueServiceService } from '../service/issue-service.service';
import { MailServiceService } from '../service/mail-service.service';

@Component({
  selector: 'app-mail',
  templateUrl: './mail.component.html',
  styleUrls: ['./mail.component.css']
})
export class MailComponent implements OnInit {
  customerId:number;
  operatorId:number;
  details:EmailDetails=new EmailDetails();
  msg:string;
  constructor(private ms:MailServiceService,private is:IssueServiceService) { }

  ngOnInit() {

  }
  public sendingModificationMail(){
    this.details.subject='Modification Mail';
    this.is.findOptByCustId(this.customerId).subscribe(response=>{
      this.operatorId=response;
      console.log(this.operatorId);
      this.ms.sendMdificationMail(this.details,this.customerId,this.operatorId).subscribe(response=>{
        alert("mail sending");
      this.msg=response;
      console.log(this.msg);
      if(this.msg=='mail send successfully...'){
        //alert("mail sending");
      }
      window.location.reload();
    })
   });
  }

}
