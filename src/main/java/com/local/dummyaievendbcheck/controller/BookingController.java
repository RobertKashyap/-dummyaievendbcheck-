package com.local.dummyaievendbcheck.controller;

import com.local.dummyaievendbcheck.model.BookingDTO;
import com.local.dummyaievendbcheck.service.BookingService;
import com.local.dummyaievendbcheck.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(final BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("bookings", bookingService.findAll());
        return "booking/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("booking") final BookingDTO bookingDTO) {
        return "booking/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("booking") @Valid final BookingDTO bookingDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "booking/add";
        }
        bookingService.create(bookingDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("booking.create.success"));
        return "redirect:/bookings";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("booking", bookingService.get(id));
        return "booking/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("booking") @Valid final BookingDTO bookingDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "booking/edit";
        }
        bookingService.update(id, bookingDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("booking.update.success"));
        return "redirect:/bookings";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        bookingService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("booking.delete.success"));
        return "redirect:/bookings";
    }

}
