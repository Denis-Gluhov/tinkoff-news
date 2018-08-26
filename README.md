# tinkoff-news
Приложение "Tinkoff-News v2.0" для OS Android. (Material Design, Dagger2, RxJava2, Retrofit2, Moxy, Room)
Тинькофф-новости v2.0
Создать приложение "Тинькофф Новости", которое будет загружать из API https://api.tinkoff.ru/v1/news заголовки новостей банка и показывать их в виде списка. 
В каждом элементе списка i должен отображаться текст из поля payload[i].text. Список должен быть отсортирован по полю publicationDate по убыванию. Полученные данные должны кешироваться на клиенте. Данные должны обновляться после оттягивания (pull-to-refresh).
При нажатии на каждую новость, она должна открывать новый экран и показывать содержимое (payload.content) загруженное из API https://api.tinkoff.ru/v1/news_content?id={ payload[i].id}.
