<div class="modal fade" id="registration-modal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">${modalheader}</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="registration-form">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="login">${login}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" id="login" name="login"
                                       placeholder="${login}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="password1">${password}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="password" name="password1" id="password1"
                                       placeholder="${password}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="password2">${password}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="password" name="password2" id="password2"
                                       placeholder="${password}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">${name}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" name="name" id="name"
                                       placeholder="${name}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="secondName">${secondName}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" name="secondName" id="secondName"
                                       placeholder="${secondName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="midleName">${midleName}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" name="midleName" id="midleName"
                                       placeholder="${midleName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="certificateNumber">${certificateNumber}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="number" name="certificateNumber"
                                       id="certificateNumber"
                                       placeholder="${certificateNumber}">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">${close}</button>
                <button id="save" type="button" class="btn btn-primary">${save}</button>
            </div>
        </div>
    </div>
</div>