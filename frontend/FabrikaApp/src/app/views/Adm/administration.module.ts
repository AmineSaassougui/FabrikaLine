import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CardModule, GridModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { AdministrationComponent } from './administration.component';
import { AdministrationRoutingModule } from './administration-routing.module';
import { UserListComponent } from './user-list/user-list.component';
import { CountryListComponent } from './country-list/country-list.component';
import { UserGenderListComponent } from './user-gender/user-gender-list.component';
import { UserGenderFormComponent } from './user-gender/user-gender-form.component';
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


import {
  AvatarModule,
  BadgeModule,
  BreadcrumbModule,
  ButtonGroupModule,
  ButtonModule,
  DropdownModule,
  FooterModule,
  FormModule,
  HeaderModule,
  ListGroupModule,
  NavModule,
  ProgressModule,
  SharedModule,
  SidebarModule,
  TabsModule,
  UtilitiesModule,
  
} from '@coreui/angular';
@NgModule({
  imports: [
  CardModule,
    GridModule,
    IconModule,
    CommonModule,
    AdministrationRoutingModule,
    syncGridModule,
        FormsModule,  AvatarModule,
        BadgeModule,
        BreadcrumbModule,
        ButtonGroupModule,
        ButtonModule,
        DropdownModule,
        FooterModule,
        FormModule,
        HeaderModule,
        ListGroupModule,
        NavModule,
        ProgressModule,
        SharedModule,
        SidebarModule,
        TabsModule,
        UtilitiesModule,

  ],
  declarations: [
    AdministrationComponent, UserListComponent, CountryListComponent, UserGenderListComponent, UserGenderFormComponent
  ],
  exports: [UserListComponent, CountryListComponent, UserGenderListComponent,UserGenderFormComponent ]
})
export class AdministrationModule {
}
