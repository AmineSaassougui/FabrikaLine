import { Component, OnInit } from '@angular/core';
import { ItemRestControllerService } from "../../../../../libs/openapi/src";
import {NavigationExtras, Router} from '@angular/router';

@Component({
  selector: 'app-item-view',
  templateUrl: './item-view.component.html',
  styleUrls: ['./item-view.component.scss']
})
export class ItemViewComponent implements OnInit {
  particlesOptions = {
    particles: {
      color: {
        value: ['#ffffff', '#ffffff']
      },
      size: {
        value: 1
      },
      lineLinked: {
        enable: true,
        color: 'random'
      },
      move: {
        enable: true,
        speed: 1.5
      }
    }
  };
  articles: any[] = [];

  slides: any[] = new Array(3).fill({ id: -1, src: '', title: '', subtitle: '' });

  constructor(private fabrikaService: ItemRestControllerService, private router: Router) { }

  ngOnInit(): void {
    this.slides[0] = {
      id: 0,
      src: 'assets/images/picad1.jpg',
      title: 'First slide',
      subtitle: 'Nulla vitae elit libero, a pharetra augue mollis interdum.'
    };
    this.slides[1] = {
      id: 1,
      src: 'assets/images/picad2.jpg',
      title: 'Second slide',
      subtitle: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
    };
    this.slides[2] = {
      id: 2,
      src: 'assets/images/picad3.jpg',
      title: 'Third slide',
      subtitle: 'Praesent commodo cursus magna, vel scelerisque nisl consectetur.'
    };
    this.slides[1] = {
      id: 1,
      src: 'assets/images/picad4.jpg',
      title: 'Second slide',
      subtitle: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
    };

    this.loadArticles();
  }

  loadArticles() {
    this.fabrikaService.getAllItemsWithAttachments().subscribe(
      (data: any[]) => {
        this.articles = data;
        console.log('Fetched items with attachments:', data);
      },
      (error) => {
        console.error('Error fetching items with attachments:', error);
      }
    );
  }

  viewItemDetails(itemId: string) {

    const navigationExtras: NavigationExtras = {
      state: {
        id: itemId,
      }
    };
    var routerPath = `/home/ItemDetails`;
    this.router.navigateByUrl(routerPath, navigationExtras);
  }
}
