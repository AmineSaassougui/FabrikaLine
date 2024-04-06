import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit  {
  public title = 'home';
  constructor(private route: ActivatedRoute) {}


  ngOnInit(): void {
  }

}
