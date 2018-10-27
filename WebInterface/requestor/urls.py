from . import views
from django.urls import path, include

urlpatterns = [
    path('', views.request_list, name='request_list'),
	# path('requestor', views.requestor_list, name='requestor_list'),
	# path('collector', views.collector_list, name='collector_list'),
	path('new', views.request_new, name='request_new'),
]
