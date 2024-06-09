import {Component, ViewChild} from '@angular/core';
import { CommonModule } from '@angular/common';
import {NavigationExtras, Router} from "@angular/router";
import {AttachmentRestControllerService, ComplaintTypeControllerService} from "../../../../../libs/openapi/src";
import {GridComponent} from "@syncfusion/ej2-angular-grids";

@Component({
  selector: 'app-complaint-type-list',
  templateUrl: './complaint-type-list.component.html',
  styleUrl: './complaint-type-list.component.css'
})

export class ComplaintTypeListComponent {
  public parentId : any ;

  constructor(private route: Router, private fabrikaService: ComplaintTypeControllerService) { }
  ngOnInit(): void {
    this.parentId = history.state.parentId;
    this.load();
  }

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this.fabrikaService.getAllComplaintType().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }


  delete() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this.fabrikaService.deleteComplaintType(selectedrecord['id']).subscribe((data: any) => {
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

  /*add(){
    const navigationExtras: NavigationExtras = {
      state: {
        parentId: this.parentId
      }
    };
    var routerPath = `/Adm/AttachementForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }

   */



  public edit(selectedrecord: any) {

    const navigationExtras: NavigationExtras = {
      state: {
        id: selectedrecord.id,
      }
    };
    var routerPath = `/Adm/AttachementForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}



