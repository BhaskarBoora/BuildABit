# Generated by Django 2.0.9 on 2018-10-26 22:46

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('requestor', '0004_auto_20181027_0400'),
    ]

    operations = [
        migrations.AddField(
            model_name='pickuprequest',
            name='typechar',
            field=models.CharField(blank=True, max_length=50, null=True),
        ),
        migrations.AlterField(
            model_name='pickuprequest',
            name='typeofwaste',
            field=models.IntegerField(),
        ),
    ]