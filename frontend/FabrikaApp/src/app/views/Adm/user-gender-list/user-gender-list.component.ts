import { Component, OnInit, ViewChild } from '@angular/core';
import { GridComponent } from '@syncfusion/ej2-angular-grids';
import { UserGenderRestControllerService } from 'libs/openapi/src';

@Component({
  selector: 'app-user-gender-list',
  templateUrl: './user-gender-list.component.html',
})
export class UserGenderListComponent implements OnInit {

  constructor(private _countryService: UserGenderRestControllerService) { }

  ngOnInit(): void {
    this.load();
  }

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this._countryService.getAll().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }

}
