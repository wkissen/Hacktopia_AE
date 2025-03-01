import { Component, Input, Output, EventEmitter } from '@angular/core';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-disease-card-popup',
  templateUrl: './disease-card-popup.component.html',
  standalone: true,
  imports: [NgIf]
})
export class DiseaseCardPopupComponent {
  @Input() disease: any;
  @Input() medicine: any; 
  @Output() closePopup = new EventEmitter<void>();

  onClose(): void {
    this.closePopup.emit();
  }
}
