import { Component, Input } from '@angular/core';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-disease-card',
  templateUrl: './disease-card.component.html',
  styleUrls: ['./disease-card.component.css'],
  imports: [
    NgIf
  ],
  standalone: true
})
export class DiseaseCardComponent {
  @Input() disease: any;
}
