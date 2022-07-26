import { Component, OnInit } from '@angular/core';
import { Operator } from '../model/operator';
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-find-operator',
  templateUrl: './find-operator.component.html',
  styleUrls: ['./find-operator.component.css']
})
export class FindOperatorComponent implements OnInit {
  departmentId:number;
  operator:Operator;
  constructor(private ds:DepartmentserviceService) { }

  ngOnInit() {
  }
  public searchOpt(){
    //this.department.departmentId=this.departmentId;
    this.ds.extractOptById(this.departmentId).subscribe(response=>{
      this.operator=response;
      console.log(response);
    })
  }

}
