import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryRestControllerService } from './../../../../../libs/openapi/src';
import { GridComponent } from '@syncfusion/ej2-angular-grids';
@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
})
export class CountryListComponent implements OnInit {

  constructor(private _countryService: CountryRestControllerService) { }

  ngOnInit(): void {
    this.load();
  }

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this._countryService.getAll6().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }

}
