import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-operator-menu',
  templateUrl: './operator-menu.component.html',
  styleUrls: ['./operator-menu.component.css']
})
export class OperatorMenuComponent implements OnInit {
name:string;
  constructor(private router:ActivatedRoute) { }

  ngOnInit() {
    this.name=this.router.snapshot.params['name'];
  }

}
