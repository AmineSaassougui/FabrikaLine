import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { GridComponent } from '@syncfusion/ej2-angular-grids';
import { UserRestControllerService } from 'libs/openapi/src';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
})
export class UserListComponent implements OnInit {
  constructor(private route: Router, private _userService: UserRestControllerService) { }




  ngOnInit() {

    this.load();

  }

  @ViewChild('grid') public grid!: GridComponent;


    load() {
    this._userService.getAllUser().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
   }

     delete() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this._userService.deleteUser(selectedrecord['id']).subscribe((data: any) => {
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
    var routerPath = `/Adm/UserForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}
















