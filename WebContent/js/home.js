const banners = document.querySelector('#banners');
slides = document.querySelectorAll('#banners img');
slideSize= slides.length;
let idx = 0;
let prevIdx = (idx+1) % slideSize;
function bannderSlider(){
  setInterval(function(){
    prevIdx = idx;
    idx = (idx+1) % slideSize;
    slides[idx].setAttribute("style","display:block;opacity: 1;transition: 0.9s;");
    slides[prevIdx].setAttribute("style","display:block;opacity: 0;transition: 0.9s;");
  },4000);
}

bannderSlider();


// const images = document.querySelectorAll('#banners img');
// let current = 0;

// function showSlide() {
//   for(let i=0; i<images.length; i++) {
//     images[i].classList.remove('on');
//   }
//   current++;
//   if(current > images.length) {
//     current = 1;
//   }
//   images[current - 1].classList.add('on');
//   setTimeout(showSlide, 2000);
// }

// show Slide();