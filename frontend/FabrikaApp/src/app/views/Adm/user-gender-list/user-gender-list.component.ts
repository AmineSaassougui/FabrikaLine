import { Component, OnInit, ViewChild } from '@angular/core';
import { UserGenderRestControllerService } from './../../../../../libs/openapi/src/api/userGenderRestController.service';
import { GridComponent } from '@syncfusion/ej2-angular-grids';

@Component({
  selector: 'app-user-gender-list',
  templateUrl: './user-gender-list.component.html',
})
export class UserGenderListComponent implements OnInit {

  constructor(private _fabrikaService: UserGenderRestControllerService) { }

  ngOnInit(): void {
    this.load();
  }

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this._fabrikaService.getAll().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }


}
