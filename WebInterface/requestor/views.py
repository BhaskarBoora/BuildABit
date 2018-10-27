from django.shortcuts import render
from django.utils import timezone
from .models import PickUpRequest
from .forms import RequestForm
from django.shortcuts import redirect

# Create your views here.
def request_list(request):
    requests = PickUpRequest.objects.filter(request_date__lte=timezone.now()).order_by('request_date')
    return render(request, 'requestor/request_list.html', {'requests': requests})

# def requestor_list(request):
#     return render(request, 'requestor/requestor_list.html', {})

# def collector_list(request):
#     return render(request, 'requestor/collector_list.html', {})

def request_new(request):
    if request.method == "POST":
        form = RequestForm(request.POST)
        if form.is_valid():
            post = form.save(commit=False)
            post.requestor = request.user
            post.request_date = timezone.now()
            post.save()
            return redirect('request_list')
    else:
        form = RequestForm()
    return render(request, 'requestor/request_edit.html', {'form': form})

