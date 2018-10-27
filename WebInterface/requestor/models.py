
from django.db import models
from django.utils import timezone
# from django.contrib.auth.models import AbstractUser

# class User(AbstractUser):
#     is_requestor = models.BooleanField(default=False)
#     is_collector = models.BooleanField(default=False)

# class Requestor(models.Model):
#         user = models.OneToOneField(User, on_delete=models.CASCADE, primary_key=True)
#     name = models.CharField(max_length=50)
#     address = models.CharField(max_length=200)
#     aadhar = models.BigIntegerField()

#     def __str__(self):
#         return self.name

# class Collector(models.Model):
#         user = models.OneToOneField(User, on_delete=models.CASCADE, primary_key=True)
#     name = models.CharField(max_length=50)
#     address = models.CharField(max_length=200)
#     aadhar = models.BigIntegerField()
#     typeofcollector = models.IntegerField()

#     def __str__(self):
#         return self.name

class PickUpRequest(models.Model):
    requestor = models.ForeignKey('auth.User', on_delete=models.CASCADE)
    # typeofwaste = models.IntegerField()
    typeofwaste = models.CharField(max_length=50,blank=True,null=True)
    request_date = models.DateTimeField(
            blank=True, null=True)
    # pickup_date = models.DateTimeField(
    #         blank=True, null=True)

    # def publish(self):
    #     self.pickup_date = timezone.now()
    #     self.save()

    def __str__(self):
        return self.typeofwaste


