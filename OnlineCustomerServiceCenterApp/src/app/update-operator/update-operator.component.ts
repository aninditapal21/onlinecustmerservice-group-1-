import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Operator } from '../model/operator'
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-update-operator',
  templateUrl: './update-operator.component.html',
  styleUrls: ['./update-operator.component.css']
})
export class UpdateOperatorComponent implements OnInit {
  deptId:number;
  operatorId:number;
  firstName:string;
  lastName:string;
  email:string;
  mobile:string;
  city:string;
  operator:Operator;
  departmentId:number
  constructor(private r:ActivatedRoute,private ds:DepartmentserviceService,private router:Router) { }

  ngOnInit() {
    this.departmentId=this.r.snapshot.params['deptId'];
    console.log(this.departmentId);
    this.ds.extractOptById(this.departmentId).subscribe(response=>{
    this.operator=response;
    this.deptId=this.operator.department.departmentId;
    this.operatorId=this.operator.operatorId;
    /*this.firstName=this.operator.firstName;
    this.lastName=this.operator.lastName;
    this.email=this.operator.email;
    this.mobile=this.operator.mobile;*/
    this.city=this.operator.city;
    });
  }
  public updateOperator(){
    /*this.operator.firstName=this.firstName;
    this.operator.lastName=this.lastName;
    this.operator.email=this.email;
    this.operator.mobile=this.mobile;*/
    this.operator.city=this.city;
    this.ds.updatedOperatorById(this.operator,this.departmentId).subscribe(response=>{
      console.log(response);
      alert("operator is Updated");
      this.router.navigate(['Viewoperator']);
    })
  }

}
