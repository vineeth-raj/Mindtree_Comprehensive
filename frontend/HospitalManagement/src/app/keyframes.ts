import { keyframes, style } from "@angular/animations";


export const swing = [
    style({transform: 'none', offset: 0}),
    style({transform: 'rotate3d(1, 0, 0, -20deg)', offset: .3}),
    style({transform: 'rotate3d(1, 0, 0, 90deg)', offset: 1}),
];