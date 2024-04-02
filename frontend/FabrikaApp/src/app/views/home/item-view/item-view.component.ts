import { Component, OnInit } from '@angular/core';
import { ItemRestControllerService } from "../../../../../libs/openapi/src";

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

  constructor(private fabrikaService: ItemRestControllerService) { }

  ngOnInit(): void {
    this.slides[0] = {
      id: 0,
      src: 'assets/images/angular.jpg',
      title: 'First slide',
      subtitle: 'Nulla vitae elit libero, a pharetra augue mollis interdum.'
    };
    this.slides[1] = {
      id: 1,
      src: 'assets/images/angular.jpg',
      title: 'Second slide',
      subtitle: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
    };
    this.slides[2] = {
      id: 2,
      src: 'assets/images/angular.jpg',
      title: 'Third slide',
      subtitle: 'Praesent commodo cursus magna, vel scelerisque nisl consectetur.'
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
}
