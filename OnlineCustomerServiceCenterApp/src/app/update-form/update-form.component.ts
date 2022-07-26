import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from '../model/department';
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-update-form',
  templateUrl: './update-form.component.html',
  styleUrls: ['./update-form.component.css']
})
export class UpdateFormComponent implements OnInit {
  deptId:number;
  departmentId:number;
  deptName:string;
  depertment:Department;
  constructor(private r:ActivatedRoute,private ds:DepartmentserviceService,private router:Router ) { }

  ngOnInit() {
    this.departmentId=this.r.snapshot.params['deptId'];
    console.log(this.departmentId);
    this.ds.extractdeptById(this.departmentId).subscribe(response=>{
      this.depertment=response;
      this.departmentId=this.depertment.departmentId;
      this.deptName=this.depertment.departmentName;
    });
  }
  public updatedDepartment(){
    this.depertment.departmentId=this.departmentId;
    this.depertment.departmentName=this.deptName;
    this.ds.updatedProductById(this.depertment,this.depertment.departmentId).subscribe(response=>{
      console.log(response);
      alert("Department is Updated");
      this.router.navigate(['viewDepartment']);
    })
  }

}
