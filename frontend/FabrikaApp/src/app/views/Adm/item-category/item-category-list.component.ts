import { Component, OnInit, ViewChild } from '@angular/core';
import { ItemCategoryRestControllerService } from './../../../../../libs/openapi/src/api/itemCategoryRestController.service';
import { Router, NavigationExtras } from '@angular/router';
import { GridComponent } from '@syncfusion/ej2-angular-grids';

@Component({
  selector: 'app-item-category-list',
  templateUrl: './item-category-list.component.html',
  styleUrls: ['./item-category-list.component.css']
})
export class ItemCategoryListComponent implements OnInit {



  constructor(private route: Router, private _countryService: ItemCategoryRestControllerService) { }
  ngOnInit(): void {
    this.load();
  }

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this._countryService.getAllItemCategory().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }


  delete() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this._countryService.deleteItemCategory(selectedrecord['id']).subscribe((data: any) => {
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
    var routerPath = `/Adm/ItemCategoryForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}
