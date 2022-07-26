import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Operator } from '../model/operator';
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-view-operator',
  templateUrl: './view-operator.component.html',
  styleUrls: ['./view-operator.component.css']
})
export class ViewOperatorComponent implements OnInit {
  msg:string;
  operators:Operator[]=[];
  constructor(private ds:DepartmentserviceService,private router:Router) { }

  ngOnInit() {
    this.ds.extractOperator().subscribe(response=>{
      this.operators=response;
      console.log(response);
    });
  }
  public deleteOpt(departmentId:number){
    this.ds.deleteOpt(departmentId).subscribe(response=>{
      console.log(response);
      //this.msg=`${depart}`
      alert("Operator deleted");
      window.location.reload();
    });
  }
  /*public deleteDept(departmentId:number){
    this.ds.deletedept(departmentId).subscribe(response=>{
      console.log(response);
      this.msg=`${departmentId}`+" deleted";
      alert(this.msg);
      window.location.reload();
    });  
  }*/
  public editOpt(departmentId:number){
    this.router.navigate(['updateOperator',departmentId]);
  }

}
