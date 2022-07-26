import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../model/department';
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-view-department',
  templateUrl: './view-department.component.html',
  styleUrls: ['./view-department.component.css']
})
export class ViewDepartmentComponent implements OnInit {
  msg:string="";
  departments:Department[]=[];
  constructor(private ds:DepartmentserviceService,private router:Router) { }

  ngOnInit() {
    this.ds.extractDepartment().subscribe(response=>{
      this.departments=response;
      console.log(this.departments);
    });
  }
  public deleteDept(departmentId:number){
    this.ds.deletedept(departmentId).subscribe(response=>{
      console.log(response);
      this.msg=`${departmentId}`+" deleted";
      alert(this.msg);
      window.location.reload();
    });  
  }
  public editDept(departmentId:number){
    this.router.navigate(['updateForm',departmentId]);
  }

}
