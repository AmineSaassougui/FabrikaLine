import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  templateUrl: 'administration.component.html',
})
export class AdministrationComponent implements OnInit {
  public title = 'Administration';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {}


}
