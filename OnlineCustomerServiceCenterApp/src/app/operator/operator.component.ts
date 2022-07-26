import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Operator } from '../model/operator';
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-operator',
  templateUrl: './operator.component.html',
  styleUrls: ['./operator.component.css']
})
export class OperatorComponent implements OnInit {
  operator = new Operator();
  constructor(private route:ActivatedRoute , private ds:DepartmentserviceService) { }

  ngOnInit() {
  }
  public addOperator(){
    console.log(this.operator);
    this.ds.addOperator(this.operator).subscribe((p)=>{
      //this.msg=p['message'];
      //console.log(this.msg);
      alert("operator added");
      window.location.reload();
    }
    );
  }

}
