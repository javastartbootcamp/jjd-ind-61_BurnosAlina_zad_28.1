insert into category (id, description, name)
values (1, 'Bardzo fajne przedmioty', 'Elektronika'),
       (2, 'Samochody, skutery i ciężarówki', 'Moto'),
       (3, 'Najpiękniejsze meble do Twojego domu', 'Meble');

insert into offer (description, img_url, price, title, category_id)
values
    ('Super telewizor o przekątnej 55 cali', 'https://image.ceneostatic.pl/data/products/92744823/i-xiaomi-mi-led-tv-4a-32.jpg', 1299, 'Telewizor', 1),
    ('Wypasione kino domowe firmy Sony, gra tak, że można robić festyn', 'https://bi.im-g.pl/im/fd/7b/19/z26722301AMP,Jak-stworzyc-kino-domowe-.jpg', 699, 'Kino domowe', 1),
    ('Najszybszy samochód w mieście', 'https://ocdn.eu/pulscms-transforms/1/bs3k9kpTURBXy85ZWYxZjcwMGU2Yjk5NDM0MWEyZTJhODUxMjkwMjkxZi5qcGeSlQMAHM0DhM0B-pMFzQSwzQKk3gACoTABoTEA', 80499, 'Fiat 126p', 2),
    ('Idealny stół drewniany dla rodziny, 6 krzeseł gratis', 'https://modo4u.pl/65011-large_default/drewniany-stol-do-jadalni-160-noga-x.jpg', 2699, 'Stół drewniany', 3);