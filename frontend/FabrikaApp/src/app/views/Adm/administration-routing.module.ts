import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CountryListComponent } from './country-list/country-list.component';
import { UserGenderListComponent } from './user-gender/user-gender-list.component';
import { UserGenderFormComponent } from './user-gender/user-gender-form.component';

const routes: Routes = [
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
