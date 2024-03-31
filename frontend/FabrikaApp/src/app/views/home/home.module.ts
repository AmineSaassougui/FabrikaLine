import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CardModule, GridModule, ToastModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
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
  declarations: [],
  imports: [
    CardModule,
    GridModule,
    IconModule,
    CommonModule,
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
        ToastModule,
  ]
})
export class HomeModule { }
