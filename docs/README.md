# Roboast User Guide

Welcome to your Robo Assitance applicaiton. Here we - the assistance will help you manage all of your tasks, such as to do list, deadlines, and events with ease. Simply tell us what you want to do, and we will do just that!

## List all the current items

Syntax: list

This will list all the current item in the list with their information such as done or not, Deadlines' deadline, Event's start and end data, etc.

## Mark/unmark item

Syntax: {mark/unmark} {item no}

Example: `mark 1`, `unmark 3`

mark will denote the item as finished and unmark will revert the status to unfinished

## Adding item

Syntax: {item type} {name of item}
{item type} includes: todo, deadline, event

Example: `todo eat dinner`, `deadline do cs2113 project \by 2 March`

Add the item into the item list

## Delete all finished

Syntax: deleteAll

Delete all the items denoted as finished from the list

## Delete specific item

Syntax: delete {item no}

Delete the item with that number in the list

## Find the item

Syntax: find {item name}

List all the item containing name

## List out list of command

Just type a random command, an error message will appear, but also the list of command!