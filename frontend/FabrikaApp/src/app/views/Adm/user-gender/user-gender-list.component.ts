import { Component, OnInit, ViewChild } from '@angular/core';
import { GridComponent } from '@syncfusion/ej2-angular-grids';
import { UserGenderRestControllerService } from './../../../../../libs/openapi/src/api/userGenderRestController.service';
import { NavigationExtras, Router } from '@angular/router';
@Component({
  selector: 'app-user-gender-list',
  templateUrl: './user-gender-list.component.html',
})
export class UserGenderListComponent implements OnInit {


  constructor(private route: Router, private _countryService: UserGenderRestControllerService) { }
  ngOnInit(): void {
    this.load();
  }

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this._countryService.getAllUserGender().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }


  delete() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this._countryService.deleteUserGender(selectedrecord['id']).subscribe((data: any) => {
        this.load()
      });
    }
  }


  public onDoubleClick(event: any): void {
    this.edit(event.rowData);
  }

  modify() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; 
      this.edit(selectedrecord);
    }
  }



  public edit(selectedrecord: any) {

    const navigationExtras: NavigationExtras = {
      state: {
        id: selectedrecord.id,
      }
    };
    var routerPath = `/Adm/UserGenderForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}



