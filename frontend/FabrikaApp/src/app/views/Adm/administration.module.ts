import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CardModule, GridModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { AdministrationComponent } from './administration.component';
import { AdministrationRoutingModule } from './administration-routing.module';
import { UserListComponent } from './user-list/user-list.component';
import { CountryListComponent } from './country-list/country-list.component';
import { UserGenderListComponent } from './user-gender-list/user-gender-list.component';

import {
  ColumnChooserService,
  EditService,
  ExcelExportService,
  FreezeService,
  GridModule as syncGridModule,
  PageService,
  PagerModule,
  PdfExportService,
  ReorderService,
  SortService,
  ToolbarService,
  ResizeService as GridResizeService,
} from '@syncfusion/ej2-angular-grids';

@NgModule({
  imports: [
  CardModule,
    GridModule,
    IconModule,
    CommonModule,
    AdministrationRoutingModule,
    syncGridModule
  ],
  declarations: [
    AdministrationComponent, UserListComponent, CountryListComponent, UserGenderListComponent
  ],
  exports: [UserListComponent, CountryListComponent, UserGenderListComponent]
})
export class AdministrationModule {
}
