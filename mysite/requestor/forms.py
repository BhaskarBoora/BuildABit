from django import forms
from .models import PickUpRequest


# class CollectorSignUpForm(UserCreationForm):
    
#     interests = forms.ModelMultipleChoiceField(
#         queryset=Subject.objects.all(),
#         widget=forms.CheckboxSelectMultiple,
#         required=True
#     )

#     class Meta(UserCreationForm.Meta):
#         model = User

#     @transaction.atomic
#     def save(self):
#         user = super().save(commit=False)
#         user.is_collector = True
#         user.save()
#         student = Collector.objects.create(user=user)
#         student.interests.add(*self.cleaned_data.get('interests'))
#         return user

class RequestForm(forms.ModelForm):

    class Meta:
        model = PickUpRequest
        fields = ('typeofwaste',)
