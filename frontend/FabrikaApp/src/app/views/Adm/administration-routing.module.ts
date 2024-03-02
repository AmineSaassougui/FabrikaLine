import { ItemFormComponent } from './item/item-form.component';
import { ItemListComponent } from './item/item-list.component';
import { ItemCategoryFormComponent } from './item-category/item-category-form.component';
import { ItemCategoryListComponent } from './item-category/item-category-list.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CountryListComponent } from './country-list/country-list.component';
import { UserGenderListComponent } from './user-gender/user-gender-list.component';
import { UserGenderFormComponent } from './user-gender/user-gender-form.component';

import { AttachementListComponent } from './attachement/attachement-list.component';
import { AttachementFormComponent } from './attachement/attachement-form.component';
const routes: Routes = [
  {
    path: 'AttachementList',
    component: AttachementListComponent,
    data: {
      title: 'Attachement'
    }
  },
  {
    path: 'AttachementForm',
    component: AttachementFormComponent,
    data: {
      title: 'Attachement'
    }
  },
  {
    path: 'ItemList',
    component: ItemListComponent,
    data: {
      title: 'Article'
    }
  },
  {
    path: 'ItemForm',
    component: ItemFormComponent,
    data: {
      title: 'Article'
    }
  },
  {
    path: 'ItemCategoryForm',
    component: ItemCategoryFormComponent,
    data: {
      title: 'Catégory acticle'
    }
  },
  {
    path: 'ItemCategoryList',
    component: ItemCategoryListComponent,
    data: {
      title: 'Catégory acticle'
    }
  },
  {
    path: 'UserList',
    component: UserListComponent,
    data: {
      title: 'Utilisateur'
    }
  },
  {
    path: 'CountryList',
    component: CountryListComponent,
    data: {
      title: 'Pays'
    }
  },
   {
    path: 'UserGenderList',
    component: UserGenderListComponent,
    data: {
      title: 'Sexe'
    }
  },
  {
    path: 'UserGenderForm',
    component: UserGenderFormComponent,
    data: {
      title: 'Sexe'
    }
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule {
}
