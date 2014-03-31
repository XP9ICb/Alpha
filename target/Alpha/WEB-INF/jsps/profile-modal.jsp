<div class="modal fade" id="profile-modal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">${modalProfileHeader}</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="profile-form">
                    <fieldset>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">${userName}</label>

                            <div class="col-md-8">
                                <a href="#" id="name" data-type="text"
                                   data-pk="${userProfile.getId()}" data-url="profile-inline-editing.htm">${userProfile.getName()}</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="second_name">${userSecondName}</label>

                            <div class="col-md-8">
                                <a href="#" id="second_name" data-type="text"
                                   data-pk="${userProfile.getId()}" data-url="profile-inline-editing.htm">${userProfile.getSecondName()}</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="midle_name">${userMidleName}</label>

                            <div class="col-md-8">
                                <a href="#" id="midle_name" data-type="text" data-pk="${userProfile.getId()}" data-url="profile-inline-editing.htm">${userProfile.getMidleName()}</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="certificate_number">${userCertificateNumber}</label>

                            <div class="col-md-8">
                                <a href="#" id="certificate_number" data-type="text" data-pk="${userProfile.getId()}" data-url="profile-inline-editing.htm">${userProfile.getCertificateNumber()}</a>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>